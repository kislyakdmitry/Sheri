<!DOCTYPE html>
<html>
<head>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
            integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
            integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
          integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <title>Blog</title>
</head>

<body>
<form class="ml-3 mt-3">
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <div class="form-group row">
        <label for="Username" class="col-sm-1 col-form-label">Username</label>
        <div class="col-sm-2">
            <input type="text" class="form-control" id="Username" value="${user.username}">
        </div>
    </div>
    <#list roles as role>
        <div class="custom-control custom-switch">
            <input type="checkbox" class="custom-control-input" id="${role.authority}"
                name="${role.authority}" ${user.role?seq_contains(role)?string("checked","")}>
            <label class="custom-control-label" for="${role.authority}">${role.authority}</label>
        </div>
    </#list>
    <div class="form-group row mt-3">
        <div class="col-sm-10">
            <button type="submit" class="btn btn-primary">Save</button>
        </div>
    </div>
</form>
</body>
</html>