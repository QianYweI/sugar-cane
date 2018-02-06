<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="CONTENT-TYPE" content="text/html; charset=UTF-8">
    <title>HttpMessageConverter Demo</title>
</head>
<body>
    <div id="resp"></div>
    <input type="button" onclick="req();" value="请求"/>
</body>
<script src="assets/js/jquery-1.12.3.min.js" type="text/javascript"></script>
<script>
    function req(){
        $.ajax({
            url: "converter",
            data: "1-ganzhe",
            type:"POST",
            contentType:"application/x-wisely",
            success: function(data) {
                $("#resp").html(data);
            }
        })
    }
</script>
</html>