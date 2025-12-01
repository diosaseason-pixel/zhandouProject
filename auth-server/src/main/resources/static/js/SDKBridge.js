/**
 * SDKBridge.js - JavaScript接口，用于与Android原生SDKBridge JavascriptInterface交互
 */
(function() {
    // 确保SDKBridge在全局范围内可用
    window.SDKBridge = window.SDKBridge || {};

    /**
     * 检查原生SDK是否可用
     * @returns {boolean} 是否可用
     */
    const isNativeBridgeAvailable = function() {
        return window.SDKBridge !== undefined && window.SDKBridge !== null;
    };

    /**
     * 生成唯一回调ID
     * @returns {string} 回调ID
     */
    const generateCallbackId = function() {
        return 'callback_' + new Date().getTime() + '_' + Math.floor(Math.random() * 10000);
    };

    // 存储回调函数
    const callbacks = {};

    /**
     * 解析JWT令牌
     * 注意：这只是一个客户端解析，不验证签名
     * @param {string} token JWT令牌
     * @returns {Object|null} 解析后的令牌数据
     */
    window.parseJwt = function(token) {
        try {
            const base64Url = token.split('.')[1];
            const base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
            const jsonPayload = decodeURIComponent(atob(base64).split('').map(function(c) {
                return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
            }).join(''));
            return JSON.parse(jsonPayload);
        } catch (e) {
            console.error('JWT解析失败', e);
            return null;
        }
    };

    /**
     * 获取头部信息
     * @param {Function} callback 回调函数，接收(code, data)参数
     */
    window.getHeader = function(callback) {
        if (!isNativeBridgeAvailable()) {
            console.error('Native SDKBridge is not available');
            return;
        }
        
        const callbackId = generateCallbackId();
        callbacks[callbackId] = callback;
        
        window.SDKBridge.getHeader(JSON.stringify({
            callback: callbackId
        }));
    };

    /**
     * 登出
     */
    window.logout = function() {
        if (!isNativeBridgeAvailable()) {
            console.error('Native SDKBridge is not available');
            return;
        }
        
        window.SDKBridge.logout(JSON.stringify({
            method: 'logout'
        }));
    };

    /**
     * 关闭WebView
     */
    window.closeWebView = function() {
        if (!isNativeBridgeAvailable()) {
            console.error('Native SDKBridge is not available');
            return;
        }
        
        window.SDKBridge.closeWebView(JSON.stringify({
            method: 'closeWebView'
        }));
    };

    /**
     * 登录成功
     * @param {Object} userInfo 用户信息
     */
    window.loginSuccess = function(userInfo) {
        if (!isNativeBridgeAvailable()) {
            console.error('Native SDKBridge is not available');
            return;
        }
        
        const loginData = {
            method: 'loginSuccess',
            param: {
                userId: userInfo.userId || '',
                uuid: userInfo.uuid || '',
                phone: userInfo.phone || '',
                age: userInfo.age || '0',
                nickname: userInfo.nickname || '',
                accessToken: userInfo.accessToken || '',
                isRegGame: userInfo.isRegGame || 0,
                isAuthentication: userInfo.isAuthentication || true
            }
        };
        
        if (userInfo.loginType !== undefined) {
            loginData.param.loginType = userInfo.loginType;
        }
        
        window.SDKBridge.loginSuccess(JSON.stringify(loginData));
    };

    // 注册全局回调处理函数
    for (const callbackName of Object.keys(callbacks)) {
        window[callbackName] = function(code, data) {
            if (callbacks[callbackName]) {
                callbacks[callbackName](code, data);
                delete callbacks[callbackName]; // 使用后删除回调
            }
        };
    }

    // 初始化完成时的提示
    console.log('SDKBridge.js 已加载');
})(); 