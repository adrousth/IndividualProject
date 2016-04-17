<form class="navbar-form navbar-right" action="/searchBar" method="get">
    <div class="form-group">
        <label for="select" class="control-label">Search By:</label>
        <select class="form-control" name="select" id="select">
            <option value="">----</option>
            <option value="firstName">Author first name</option>
            <option value="lastName">Author last name</option>
            <option value="title">Title</option>
            <option value="isbn">ISBN</option>
        </select>
        <input class="form-control" placeholder="Search" type="text" id="searchParam" name="searchParam"/>
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
</form>