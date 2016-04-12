<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h3>Search Results Home Page</h3>


<ul class="pagination container center-block">
    <li class="disabled"><a href="#">&laquo;</a></li>
    <li class="active"><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
    <li><a href="#">&raquo;</a></li>
</ul>
    <c:forEach var="book"  items="${results}">

            <div class="container panel panel-primary col-lg-7">
                <div class="panel-heading">
                    <h3 class="panel-title">${book.title}</h3>
                </div>
                <div class="panel-body">
                    <ul class="container col-lg-3">
                        <li>ISBN: ${book.isbn}</li>
                        <li>Publisher: ${book.publisher}</li>
                        <li>Edition: ${book.edition}</li>
                        <li>Copies: ${book.copies}</li>
                        <li>Copies Available: ${book.availableCopies}</li>
                        <li>Number of Pages: ${book.numberPages}</li>
                        <li>Format: ${book.format}</li>
                    </ul>
                    <div class="container col-lg-8">

                            ${book.description}

                    </div>
                </div>
            </div>

    </c:forEach>



<ul class="pagination container center-block">
    <li class="disabled"><a href="#">&laquo;</a></li>
    <li class="active"><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
    <li><a href="#">&raquo;</a></li>
</ul>