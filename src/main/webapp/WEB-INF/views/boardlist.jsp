<%--
  Created by IntelliJ IDEA.
  User: 박민준
  Date: 2023-12-01
  Time: 오전 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
            crossorigin="anonymous"></script>
    <title>Title</title>
    <script>
        function delete_ok(id){
            var a = confirm("정말로 삭제하시겠습니까?");
            if(a) location.href='../deleteok/'+id;
        }
    </script>
</head>
<body>
<h2>Section title</h2>
<div class="table-responsive small">
    <table class="table table-striped table-sm">
        <c:forEach items="${list}" var="one"  >
        <tr>
            <td>${one.seq}</td>
            <td>${one.title}</td>
            <td>${one.writer}</td>
            <td>${one.category}</td>
            <td>${one.content}</td>
            <td>${one.regdate}</td>
            <td>${one.moddate}</td>
            <td><a href="../editform/${one.seq}">수정하기</a></td>
            <td><a href="javascript:delete_ok('${one.seq}')">삭제하기</a></td>
        </tr>

        </c:forEach>
    </table>

    <br><a href="../add">Add new post</a>

</div>
</body>
</html>
