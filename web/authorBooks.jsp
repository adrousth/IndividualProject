<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <p>Books by <a href="${json.author.link}">${json.author.name}</a> courtesy of <a href="https://www.goodreads.com/">Goodreads!</a></p>
    <c:forEach begin="1" end="${json.author.books.total}" var="i">
        <ul>
            <li><a href="${json.author.books.book[i - 1].link}">${json.author.books.book[i - 1].title}</a></li>
        </ul>
    </c:forEach>


</div>