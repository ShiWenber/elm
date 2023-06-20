<!-- 同一整个web应用前端风格的模板页,包括了主页面和底部按钮带 -->
<template>

<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
        integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">

    <link href="../dist/output.css" type="text/css" rel="stylesheet">

    <!-- 使用的特殊的css样式的位置 -->
    <link href="../dist/registerPage.css" type="text/css" rel="stylesheet" />

</head>

<body>


    <div class="mainPad">
        <div class="headPad">
            <div class="my-2 text-lg text-center">
                用户注册
            </div>
        </div>
        <div class="bodyPad">
            <div class="line">
                <div class="w-20">
                    手机号码：
                </div>
                <div>
                    <input type="text" name="phone" id="phone" placeholder="请输入手机号码" />
                </div>
            </div>
            <div class="line">
                <div class="w-20">
                    密码：
                </div>
                <div>
                    <input type="password" name="password" id="password" placeholder="请输入密码" />
                </div>


            </div>
            <div class="line">
                <div class="w-20">
                    确认密码：
                </div>
                <div>
                    <input type="password" name="password2" id="password2" placeholder="请再次输入密码" />
                </div>
            </div>
            <div class="line">
                <div class="w-20">
                    用户姓名：
                </div>
                <div>
                    <input type="text" name="name" id="name" placeholder="请输入用户姓名" />
                </div>

            </div>
            <div class="line">
                <div class="w-20">
                    用户性别：
                </div>
                <div class="flex flex-row space-x-2">
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1"
                            value="男">
                        <label class="form-check-label" for="inlineRadio1">男</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2"
                            value="女">
                        <label class="form-check-label" for="inlineRadio2">女</label>
                    </div>
                </div>


            </div>
            <div class="py-10">
                <button class="w-3/4 text-center justify-center bg-transparent rounded-full bg-green-400 shadow-sm" id="register">注册</button>
            </div>

        </div>
    </div>




    <div class="barPad">
        <div>
            <i class="fas fa-home"></i>
            <br />首页
        </div>
        <div>
            <i class="fas fa-search"></i>
            <br />发现
        </div>
        <div>
            <i class="fas fa-shopping-cart"></i>
            <br />订单
        </div>
        <div>
            <i class="fas fa-user"></i>
            <br />我的
        </div>
    </div>


</body>

</html>
</template>