<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <div class="container col-lg-5 text-center">
        <h3>${message}</h3>
        <p></p>
        <p>Nullam quis risus eget <a href="#">urna mollis ornare</a> vel eu leo. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nullam id dolor id nibh ultricies vehicula.</p>
    </div>
    <form class="form-horizontal col-lg-4 col-lg-offset-2" action="/user/login" method="get">
        <fieldset>
            <legend>Sign In</legend>
            <div class="form-group">
                <label for="inputUserId" class="col-lg-2 control-label">User-ID</label>
                <div class="col-lg-10">
                    <input class="form-control" id="inputUserId" placeholder="User ID" type="text">
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword" class="col-lg-2 control-label">Password</label>
                <div class="col-lg-10">
                    <input class="form-control" id="inputPassword" placeholder="Password" type="password">
                </div>
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
            <span class="help-block">If you do not have an account please visit our library to sign up!</span>
        </fieldset>
    </form>
</div>