<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container col-lg-offset-2 col-lg-5">
    <c:choose>
        <c:when test="${results.success}">
            <p>new user added</p>
            <ul>
                <li>new user id: ${results.newUserId}</li>
                <li>new user password: ${results.newUserPassword}</li>
            </ul>
        </c:when>
        <c:when test="${!results.success}">
            <ul>
            <c:forEach var="message" items="${results.messages}">
                <li>${message}</li>
            </c:forEach>
            </ul>
        </c:when>
    </c:choose>

</div>
<div class="container">
<form class="form-horizontal col-lg-6 col-lg-offset-2" action="/admin/newUser" method="POST">
    <fieldset>
        <legend>New User</legend>
        <div class="form-group">
            <label for="firstName" class="col-lg-2 control-label">First Name</label>
            <div class="col-lg-10">
                <input class="form-control" id="firstName" name="firstName" placeholder="first name" type="text"/>
            </div>
        </div>
        <div class="form-group">
            <label for="lastName" class="col-lg-2 control-label">Last Name</label>
            <div class="col-lg-10">
                <input class="form-control" id="lastName" name="lastName" placeholder="last name" type="text"/>
            </div>
        </div>
        <div class="form-group">
            <label for="birthday" class="col-lg-2 control-label">Birthday</label>
            <div class="col-lg-10">
                <input class="form-control" id="birthday" name="birthday" type="date"/>
            </div>
        </div>
        <div class="form-group">
            <label for="email" class="col-lg-2 control-label">Email</label>
            <div class="col-lg-10">
                <input class="form-control" id="email" name="email" type="text"/>
            </div>
        </div>
        <div class="form-group">
            <label for="phone" class="col-lg-2 control-label">phone</label>
            <div class="col-lg-10">
                <input class="form-control" id="phone" name="phone" type="text"/>
            </div>
        </div>

        <fieldset>
            <legend>Address</legend>
            <div class="form-group">
                <label for="addressOne" class="col-lg-2 control-label">Address one</label>
                <div class="col-lg-10">
                    <input class="form-control" id="addressOne" name="addressOne" type="text"/>
                </div>
            </div>
            <div class="form-group">
                <label for="addressTwo" class="col-lg-2 control-label">Address two</label>
                <div class="col-lg-10">
                    <input class="form-control" id="addressTwo" name="addressTwo" type="text"/>
                </div>
            </div>
            <div class="form-group">
                <label for="city" class="col-lg-2 control-label">City</label>
                <div class="col-lg-3">
                    <input class="form-control" id="city" name="city" type="text"/>
                </div>
                <label for="state" class="col-lg-1 control-label">State</label>
                <div class="col-lg-2">
                    <input class="form-control" id="state" name="state" type="text" maxlength="2"/>
                </div>
                <label for="zip" class="col-lg-1 control-label">Zip code</label>
                <div class="col-lg-3">
                    <input class="form-control" id="zip" name="zip" type="text"/>
                </div>
            </div>
        </fieldset>
        <div class="col-lg-offset-2">
            <button type="submit" class="btn btn-default col-lg-7">Submit</button>
        </div>
    </fieldset>
</form>
</div>