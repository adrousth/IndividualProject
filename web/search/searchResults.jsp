<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-lg-8 col-lg-offset-2">
    <h4>Search Results</h4>
    <c:choose>
        <c:when test="">
            <h5 >Search results for ${search}</h5>
        </c:when>
        <c:otherwise>

        </c:otherwise>
    </c:choose>
    <h5>
        Showing ${(currentPage - 1) * results.booksPerPage + 1} - ${((currentPage - 1) * results.booksPerPage) + results.booksPerPage} of ${numberOfBooks} results
    </h5>
</div>
<c:if test="${numberOfPages > 1}">
    <c:import url="/search/pagination.jsp"/>
</c:if>
<div  class="container">
    <c:forEach var="book" items="${results.books}">

            <div class="container panel panel-primary col-lg-9">
                <div class="panel-heading">
                    <h3 class="panel-title">${book.title}</h3>
                </div>
                <div class="panel-body">
                    <ul class="container col-lg-3">
                        <li>ISBN: ${book.isbn}</li>
                        <li>Publisher: ${book.publisher}</li>
                        <li>Edition: ${book.edition}</li>
                        <li>Total Copies: ${book.totalCopies}</li>
                        <li>Copies Available: ${book.availableCopies}</li>
                        <li>Number of Pages: ${book.numberPages}</li>
                        <li>Format: ${book.format}</li>
                    </ul>
                    <div class="container col-lg-8">
                        <c:choose>
                            <c:when test="${book.description.length() > 900}">
                                ${book.description.substring(0, 800)}(...)
                            </c:when>
                            <c:otherwise>
                                ${book.description}
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>

    </c:forEach>
</div>


<c:if test="${numberOfPages > 1}">
    <c:import url="/search/pagination.jsp"/>
</c:if>