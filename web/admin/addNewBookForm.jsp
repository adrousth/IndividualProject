<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 3/15/2016
  Time: 5:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
<form class="form-horizontal col-lg-4 col-lg-offset-2" action="/admin/addBook" method="post">
    <fieldset>
        <legend>Add New Book Form (not currently working)</legend>

        <div class="form-group">
            <label for="isbn" class="col-lg-2 control-label">ISBN</label>
            <div class="col-lg-10">
                <input class="form-control" id="isbn" placeholder="0000000000" type="text">
            </div>
        </div>

        <div class="form-group">
            <label for="title" class="col-lg-2 control-label">Title</label>
            <div class="col-lg-10">
                <input class="form-control" id="title" placeholder="Title" type="text">
            </div>
        </div>

        <div class="form-group">
            <label for="publisher" class="col-lg-2 control-label">Publisher</label>
            <div class="col-lg-10">
                <input class="form-control" id="publisher" placeholder="Publisher" type="text">
            </div>
        </div>

        <div class="form-group">
            <label for="year" class="col-lg-2 control-label">Publish Year</label>
            <div class="col-lg-10">
                <input class="form-control" id="year" placeholder="Publish Year" type="text">
            </div>
        </div>

        <div class="form-group">
            <label for="edition" class="col-lg-2 control-label">Edition</label>
            <div class="col-lg-10">
                <input class="form-control" id="edition" placeholder="Edition" type="text">
            </div>
        </div>

        <div class="form-group">
            <label for="copies" class="col-lg-2 control-label">Copies</label>
            <div class="col-lg-10">
                <input class="form-control" id="copies" placeholder="Copies" type="text">
            </div>
        </div>
        <input type="submit" name="" value="Enter" />
    </fieldset>
</form>
</div>

<br />
<ul>
<c:forEach var="line" items="${message}">
    <li>${line}</li>
</c:forEach>
</ul>
<c:remove var="message"/>

