<div class="container">
<div class="col-lg-8 col-lg-offset-2 container">
    <h4>Search Results</h4>
    <c:choose>
        <c:when test="">
            <h5 >Search results for ${search}</h5>
        </c:when>
        <c:otherwise>

        </c:otherwise>
    </c:choose>
    <h5>
        oops, no results for that search
    </h5>
</div>
</div>