<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">MY LIBRARY</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/logout">Log out<span class="sr-only">(current)</span></a></li>
                <li class="active"><a href="#">Help<span class="sr-only">(current)</span></a></li>
                <li class="active"><a href="#">About<span class="sr-only">(current)</span></a></li>
            </ul>
            <c:import url="/sections/searchHeader.jsp"/>
        </div>
    </div>
</nav>