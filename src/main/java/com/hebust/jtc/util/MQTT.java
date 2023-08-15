package com.hebust.jtc.util;

import com.aliyun.alink.dm.api.DeviceInfo;
import com.aliyun.alink.dm.api.InitResult;
import com.aliyun.alink.linkkit.api.ILinkKitConnectListener;
import com.aliyun.alink.linkkit.api.IoTMqttClientConfig;
import com.aliyun.alink.linkkit.api.LinkKit;
import com.aliyun.alink.linkkit.api.LinkKitInitParams;
import com.aliyun.alink.linksdk.channel.core.persistent.mqtt.MqttConfigure;
import com.aliyun.alink.linksdk.cmp.connect.channel.MqttPublishRequest;

import com.aliyun.alink.linksdk.cmp.core.base.ARequest;
import com.aliyun.alink.linksdk.cmp.core.base.AResponse;
import com.aliyun.alink.linksdk.cmp.core.listener.IConnectSendListener;
import com.aliyun.alink.linksdk.tools.AError;
import com.aliyun.alink.linksdk.tools.ALog;

/**
 * @Auther: 小天
 * @Date: 2023/4/27 - 04 - 27 - 18:01
 * @Decsription: com.hebust.jtc.util
 * @version: 1.0
 */
public class MQTT {
    private static final String TAG = "HelloWorld";
    //程序入口
    //程序入口
    public static void main(String[] args) {
        init();
        System.out.println("初始化成功！");
        publish();
        System.out.println("发送了消息！");
    }
    public static void init() {
        String productKey = "h1xtHWF4pv4";
        String deviceName = "Wechat_Door";
        String deviceSecret = "560e5f8f9b4e3de255d2b62e793eaf22";
        LinkKitInitParams params = new LinkKitInitParams();
        /**
         * step 1: 设置MQTT初始化参数
         */
        IoTMqttClientConfig config = new IoTMqttClientConfig();
        config.productKey = productKey;
        config.deviceName = deviceName;
        config.deviceSecret = deviceSecret;
        MqttConfigure.mqttHost = "h1xtHWF4pv4.iot-as-mqtt.cn-shanghai.aliyuncs.com:443";
        /*
         *是否接受离线消息
         *对应MQTT的cleanSession字段
         */
        config.receiveOfflineMsg = false;
        params.mqttClientConfig = config;
        /**
         * step 2: 设置初始化设备认证信息
         */
        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.productKey = productKey;
        deviceInfo.deviceName = deviceName;
        deviceInfo.deviceSecret = deviceSecret;
        params.deviceInfo = deviceInfo;
/**
 * step 3: 设置设备的usernaem, token和clientId
 * 仅用于一型一密免预注册
 * 默认关闭
 */
        // MqttConfigure.deviceToken="${YourDeviceToken}";
        // MqttConfigure.clientId="${YourClientId}";
        LinkKit.getInstance().init(params, new ILinkKitConnectListener() {
            public void onError(AError aError) {
                ALog.e(TAG, "Init Error error= "+aError);
            }
            public void onInitDone(InitResult initResult) {
                ALog.i(TAG, "onInitDone result=" + initResult);
            }
        });
    }
    public static void publish(){
        // 发布
        MqttPublishRequest request = new MqttPublishRequest();
// 设置是否需要应答。
        request.isRPC = true;
// 设置topic，设备通过该Topic向物联网平台发送消息。
        request.topic = "/h1xtHWF4pv4/Wechat_Door/user/update";
// 设置qos
        request.qos = 0;
        String data = "hello world"; //TODO:data 设置需要发布的数据
        request.payloadObj = data;
        LinkKit.getInstance().publish(request, new IConnectSendListener() {
            @Override
            public void onResponse(ARequest aRequest, AResponse aResponse) {
                // 发布成功
            }
            @Override
            public void onFailure(ARequest aRequest, AError aError) {
                // 发布失败
            }
        });
    }
}
