<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container col-lg-offset-2 col-lg-5">
    <c:choose>
        <c:when test="${results.success}">
            <ul>
                <li>Checked out</li>
                <li>Return by: ${results.date}</li>
            </ul>
        </c:when>
        <c:otherwise>
            <ul>
                <c:forEach var="message" items="${results.messages}">
                    <li>${message}</li>
                </c:forEach>
            </ul>
        </c:otherwise>
    </c:choose>
</div>
<div class="container">
    <form class="container form-horizontal col-lg-6 col-lg-offset-2" action="/admin/checkout" method="post">
        <fieldset>
            <legend>Checkout</legend>
            <div class="form-group">
                <label for="userId" class="col-lg-2 control-label">User Id</label>
                <div class="col-lg-10">
                    <input class="form-control" id="userId" name="userId" placeholder="0000" type="text" autofocus="autofocus" maxlength="4">
                </div>
            </div>
            <div class="form-group">
                <label for="isbn" class="col-lg-2 control-label">ISBN</label>
                <div class="col-lg-5">
                    <input class="form-control" id="isbn" name="isbn" placeholder="ISBN" type="text">
                </div>
                <label for="bookNumber" class="col-lg-2 control-label">Book-num</label>
                <div class="col-lg-2">
                    <input class="form-control" id="bookNumber" name="bookNumber" placeholder="" type="text">
                </div>
            </div>
            <div class="form-group">
                <label for="days" class="col-lg-2 control-label">Days</label>
                <div class="col-lg-10">
                    <select class="form-control" id="days" name="days">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7" selected="selected">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                    </select>
                </div>
            </div>
        </fieldset>
        <div class="col-lg-offset-2">
            <button type="submit" class="btn btn-default col-lg-7">Submit</button>
        </div>
    </form>

</div>