function getPosts() {

    $.ajax(
        {
            type: "GET",
            url: "/posts",
            success: function (result) {

                postsTable(result);
            }
        }
    );
}

getPosts();

var button = document.getElementById("create-post");
button.addEventListener("click", createPost);

function createPost() {

    console.log("called!");

    var title = document.getElementById("title").value;
    var body = document.getElementById("body").value;

    $.ajax(
        {
            type: "POST",
            url: "/posts",
            data: {userId: 10, title: title, body: body},
            success: function () {

                getPosts();
            },
            dataType: "json"
        }
    );
}


//console.log("Hello!!!");


var select = document.getElementById("user-filter");
select.addEventListener("change", postFilter);

function postsTable(posts, value) {

    var postsOfTable = document.getElementById("table-content");

    var divtable = "<table class='table table-bordered'>";

    divtable = divtable + tableHeader();

    for (var i = 0; i < posts.length; i++) {

        var onePost = posts[i];

        if (value == null || value == onePost.userId) {

            divtable = divtable + "<tr><td>"
                + onePost.userId + "</td><td>"
                + onePost.id + "</td><td>"
                + onePost.title + "</td><td>"
                + onePost.body + "</td></tr>";
        }
        //console.log(onePost);
    }

    divtable = divtable + "</table>";
    postsOfTable.innerHTML = divtable;
}

function tableHeader() {

    return "<thead><tr class='danger'><th>User ID</th><th>ID</th><th>Title</th><th>Body</th></tr></thead>";
}

function tableFilter(posts) {

    var putFilter = document.getElementById("user-filter");
    var UserIDs = [];

    for (var f = 0; f < posts.length; f++) {
        var post = posts[f];
        var Userid = post.userId;

        if (UserIDs.indexOf(Userid) === -1) {
            UserIDs.push(Userid);
        }
    }

    var options = "<option value=''>Show all</option>";

    for (var a = 0; a < UserIDs.length; a++) {
        options += "<option value ='" + UserIDs[a] + "'>"
            + UserIDs[a] + "</option>";
    }

    putFilter.innerHTML = options;

}

function postFilter() {

    var selectedValue = select.options[select.selectedIndex].value;

    postsTable(posts, selectedValue);
}



