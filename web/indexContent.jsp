<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <div class="container col-lg-5 text-center">
        <h3>Home Page</h3>
        <p>${message}</p>
        <p>Nullam quis risus eget <a href="#">urna mollis ornare</a> vel eu leo. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nullam id dolor id nibh ultricies vehicula.</p>
    </div>
    <div class="container">
        <form class="form-horizontal col-lg-4 col-lg-offset-2" action="j_security_check" method="POST">
            <fieldset>
                <legend>Sign In(Does not work, use sign in link)</legend>
                <div class="form-group">
                    <label for="inputUserId" class="col-lg-2 control-label">User ID</label>
                    <div class="col-lg-10">
                        <input class="form-control" id="inputUserId" placeholder="User ID" type="text" name="j_username">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword" class="col-lg-2 control-label">Password</label>
                    <div class="col-lg-10">
                        <input class="form-control" id="inputPassword" placeholder="Password" type="password" name="j_password">
                    </div>
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
                <span class="help-block">If you do not have an account please visit our library to sign up!</span>
            </fieldset>
        </form>
    </div>
</div>