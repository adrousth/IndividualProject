<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container col-lg-12 center-block">
<ul class="pagination container center-block">

    <c:choose>
        <c:when test="${currentPage eq 1}">
            <li><a href="#" class="btn disabled">&laquo;Previous</a></li>
        </c:when>
        <c:otherwise>
            <li><a href="/search?page=${currentPage - 1}${params}">&laquo;Previous</a></li>
        </c:otherwise>
    </c:choose>



    <!-- value for forEach's begin for pages' links -->
    <c:set var="begin" value="0"/>
    <c:choose>
        <c:when test="${halfMaxPages lt currentPage}">
            <!-- begin = currentPage - halfMaxPages -->
            <c:set var="begin" value="${currentPage - halfMaxPages + 1}"/>
        </c:when>
        <c:otherwise>
            <!-- begin = 1 -->
            <c:set var="begin" value="1"/>
        </c:otherwise>
    </c:choose>


    <!-- value for forEach's end for pages' links -->
    <c:choose>
        <c:when test="${begin == 1}">
            <c:set var="end" value="${maxPages}"/>
        </c:when>
        <c:when test="${currentPage lt (numberOfPages - halfMaxPages)}">
            <!-- end = currentPage + halfMaxPages -->
            <c:set var="end" value="${currentPage + halfMaxPages}"/>
        </c:when>
        <c:otherwise>
            <!-- end = numberOfPages -->
            <c:set var="end" value="${numberOfPages}"/>
            <c:set var="begin" value="${numberOfPages - maxPages + 1}"/>
        </c:otherwise>
    </c:choose>

    <!-- end maxPages + currentPage unless currentPage lt numberOfPages - maxPages -->
    <c:forEach begin="${begin}" end="${end}" var="i">
        <c:choose>
            <c:when test="${currentPage eq i}">
                <li class="active text-center"><a href="#" style="width: 3.5em;">${i}</a></li>
            </c:when>
            <c:otherwise>
                <li class="text-center"><a href="/search?page=${i}${params}" style="width: 3.5em;">${i}</a></li>
            </c:otherwise>
        </c:choose>
    </c:forEach>

    <c:choose>
        <c:when test="${currentPage lt numberOfPages}">
            <li><a href="/search?page=${currentPage + 1}${params}">Next&raquo;</a></li>
        </c:when>
        <c:otherwise>
            <li><a class="btn disabled" href="#">Next&raquo;</a></li>
        </c:otherwise>
    </c:choose>

</ul>
</div>
