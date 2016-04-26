<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <div class="container col-lg-5 text-center">
        <h3>Home Page for *user*</h3>
        <h4>Welcome ${user.firstName} ${user.lastName}</h4>
        <p>The current *user* home page for my website, most links do not work</p>
        <p>Nullam quis risus eget <a href="#">urna mollis ornare</a> vel eu leo. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nullam id dolor id nibh ultricies vehicula.</p>
        <a href="#">change password</a>
    </div>
    <div class="container col-lg-5">
        <h4>Current checkouts</h4>
        <ul>
        <c:forEach var="rental" items="${rentals}">
            <c:if test="${rental.returnDate == null}">
                <li>
                    <ul>
                        <li>${rental.rentalId}</li>
                        <li>${rental.isbn}</li>
                        <li>${rental.bookNumber}</li>
                        <li>${rental.checkoutDate}</li>
                    </ul>
                </li>
            </c:if>
        </c:forEach>
        </ul>
    </div>
</div>