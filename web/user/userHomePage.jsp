<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <div class="container col-lg-5 text-center">
        <h3>Home Page for *user*</h3>
        <h4>Welcome ${user.firstName} ${user.lastName}</h4>
        <p>The current *user* home page for my website, most links do not work</p>
        <p>Nullam quis risus eget <a href="#">urna mollis ornare</a> vel eu leo. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nullam id dolor id nibh ultricies vehicula.</p>
        <a href="#">change password</a>
    </div>
        <h4 class="col-lg-offset-1">Current checkouts</h4>
        <c:forEach var="rental" items="${rentals}">
            <c:if test="${rental.returnDate == null}">
                <div class="container col-lg-4">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h3 class="panel-title">${rental.title}</h3>
                        </div>
                        <div class="panel-body">
                            <table class="table-condensed">
                                <tr><td>Book number:</td><td>${rental.bookNumber}</td></tr>
                                <tr><td>Checkout date:</td><td>${rental.checkout}</td></tr>
                                <tr><td>Rental time: </td><td>${rental.rentalTime}</td></tr>
                                <tr><td>Due by: </td><td>${rental.dueBy}</td></tr>
                            </table>
                        </div>
                    </div>
                </div>
            </c:if>
        </c:forEach>
</div>