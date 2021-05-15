<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <%--<script src="https://code.jquery.com/jquery-3.6.0.js"></script>--%>
    <script src="static/js/jquery-3.6.0.js"></script>
    <script>
      function a1(){
        $.post({
          url: "${pageContext.request.contextPath}/a1",
          data: {"name": $("#username").val()},
          success: function (data, status) {
            alert(data);
            alert(status)
          },
          error: function () {

          }
        })
      }

    </script>
  </head>
  <body>

  <%--失去焦点的时候，发起一个请求(携带信息)到后台--%>
  <%--onblur：失去焦点触发事件--%>
  用户名：<input type="text" id="username" onblur="a1()">

  </body>
</html>
