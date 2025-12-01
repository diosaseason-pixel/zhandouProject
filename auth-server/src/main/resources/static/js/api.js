/**
 * API请求工具类
 */
const API = {
    /**
     * 发送请求到API
     * @param {string} url - API地址
     * @param {string} method - 请求方法 (GET, POST, PUT, DELETE等)
     * @param {Object} data - 请求数据
     * @returns {Promise} - 返回Promise对象
     */
    request: function(url, method = 'GET', data = null) {
        // 构建请求选项
        const options = {
            method: method,
            headers: {
                'Content-Type': 'application/json'
            }
        };

        // 添加请求体数据
        if (data && (method === 'POST' || method === 'PUT')) {
            options.body = JSON.stringify(data);
        }

        // 如果已经登录，添加token到请求头
        const token = localStorage.getItem('accessToken');
        if (token) {
            options.headers['Authorization'] = `Bearer ${token}`;
        }

        // 发送请求
        return fetch(url, options)
            .then(response => {
                // 处理未授权错误
                if (response.status === 401) {
                    // 清除token，重定向到登录页
                    localStorage.removeItem('accessToken');
                    localStorage.removeItem('userInfo');
                    window.location.href = '/sdk/domestic';
                    throw new Error('会话已过期，请重新登录');
                }
                return response.json();
            });
    },

    /**
     * 登录
     * @param {string} username - 用户名
     * @param {string} password - 密码
     * @returns {Promise} - 返回Promise对象
     */
    login: function(username, password) {
        return this.request('/api/login', 'POST', { username, password })
            .then(response => {
                if (response.code === 0 && response.data) {
                    // 登录成功，保存用户信息到本地存储
                    localStorage.setItem('accessToken', response.data.accessToken);
                    localStorage.setItem('userInfo', JSON.stringify(response.data));
                }
                return response;
            });
    },

    /**
     * 登出
     */
    logout: function() {
        localStorage.removeItem('accessToken');
        localStorage.removeItem('userInfo');
        window.location.href = '/sdk/domestic';
    }
}; 