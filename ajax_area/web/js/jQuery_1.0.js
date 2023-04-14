/*
* 三个关键点
* 1. 想到用全局变量domObj来代替document.getElementById
* 2. 想到$代替jQuery
* 3. 想到返回的是一个新的jQuery()对象
* */
function jQuery(selector) {
    if (typeof selector == "string") {
        if (selector.charAt(0) == '#') {
            domObj = document.getElementById(selector.substring(1));
            return new jQuery();
        }
    }
    if (typeof selector == "function") {
        window.onload = selector;
    }
    this.html = function (htmlStr) {
        domObj.innerHTML = htmlStr;
    }
    this.click = function (func) {
        domObj.onclick = func;
    }
    this.change = function (func) {
        domObj.onchange = func;
    }
    this.val = function (v) {
        if (v != undefined) {
            domObj.value = v;
        } else {
            return domObj.value;
        }
    }
    // 发送ajax的函数
    // 考虑到请求方式，异步/同步，提交的数据data，url都是动态的
    jQuery.ajax = function (jsonArgs) {
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4) {
                if (xhr.status == 200) {
                    // 假设服务器返回的都是json
                    var jsonObj = JSON.parse(this.responseText);
                    // 处理json
                    // 调用函数
                    jsonArgs.success(jsonObj);
                } else {
                    alert(xhr.status);
                }
            }
        }
        // 强制全部转换成为大写
        if (jsonArgs.method.toUpperCase() == "POST") {

            xhr.open("POST", jsonArgs.url, jsonArgs.async);
            xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xhr.send(jsonArgs.data);

        }

        if (jsonArgs.method.toUpperCase() == "GET") {
            xhr.open("GET", jsonArgs.url + "?" + jsonArgs.data, jsonArgs.async);
            xhr.send();
        }


    }
}

$ = jQuery;
new jQuery();