/*
* 三个关键点
* 1. 想到用全局变量domObj来代替document.getElementById
* 2. 想到$代替jQuery
* 3. 想到返回的是一个新的jQuery()对象
* */
function jQuery(selector) {
    // selector可能是#id,也可以是其它选择器，例如.class

    //
    if (typeof selector == "string") {
        if (selector.charAt(0) == '#') {
            // selector是一个id选择器 因为id是#id开始的
            // 去掉var作为全局变量，可以在整个页面中使用
            // 这里就是创造了一个全局变量，用来代替document.getElementById(xxx)
            domObj = document.getElementById(selector.substring(1)); // 从第二位开始截string
            // 利用新的jQuery对象去使用.html方法
            return new jQuery();
        }
    }

    // 页面加载完毕之后，加载函数,如果传入的是函数的话
    if (typeof selector == "function") {
        // 当这个选择器是一个函数的时候，使它在页面加载完成的时候执行
        window.onload = selector;
    }

    // 在jQuery类中定义一个html()函数，用来代替 domObj.innerHTML = "xxx"
    // 这是js在类中定义实例方法
    this.html = function (htmlStr) {
        domObj.innerHTML = htmlStr;
    }

    // 定义一个click函数，传入的是一个function，代替 domObj.onclick = function () {...}
    this.click = function (func) {
        domObj.onclick = func;
    }

    // 定义获取元素value的function
    this.val = function (v) {
        if (v != undefined) {
            // 带有参数的时候是修改某个id中的value
            domObj.value = v;
        } else {
            return domObj.value;
        }


    }
}

// 将jQuery又用一个标识符来表示
$ = jQuery;
