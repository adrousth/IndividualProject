<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container col-lg-offset-2 col-lg-5">
    <c:choose>
        <c:when test="${results.success}">
            <ul>
                <li>${results.user.firstName} ${results.user.lastName} (${results.user.userId}) Returned book</li>
                <ul>
                    <li><div class="col-lg-2">ISBN:</div> ${results.book.isbn}</li>
                    <li><div class="col-lg-2">Book#:</div> ${results.book.bookNumber}</li>
                    <li><div class="col-lg-2">Title:</div> ${results.book.title}</li>
                    <li><div class="col-lg-2">Edition:</div> ${results.book.edition}</li>
                    <li><div class="col-lg-2">Format:</div> ${results.book.format}</li>
                </ul>
                <c:if test="${results.daysLate > 0}">
                    <li>${results.daysLate} days late</li>
                </c:if>
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
    <c:remove var="results"/>
</div>
<div class="container">
    <form class="container form-horizontal col-lg-6 col-lg-offset-2" action="/admin/returns" method="post">
        <fieldset>
            <legend>Returns</legend>
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
        </fieldset>
        <div class="col-lg-offset-2">
            <button type="submit" class="btn btn-default col-lg-7">Submit</button>
        </div>
    </form>
</div>
