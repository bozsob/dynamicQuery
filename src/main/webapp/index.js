$(document).ready(function() {

    $("#result").empty();
    $("#tables").hide();
    $("#check").click(function () {
        $.ajax({
            url: "/query",
            type: "get",
            success: function (data) {
                console.log(data);
                var htmlString = "<table><tr><th>Shemas</th></tr>";
                data.forEach(function (t) {
                    htmlString += "<tr onclick='getTables()'><td>" + t + "</td>";
                });
                htmlString += "</table>";
            $("#result").append(htmlString);
            }
        })
    })
    $("#result").show();
});

function getTables() {

    $("#tables").empty();
    $("#result").hide();
    var shemaName = $("td").val();
    $.ajax({
        url: "/table",
        type: "get",
        data: {"shema" : shemaName},
        success: function (data) {
            console.log(data);
            var htmlString = "<table><tr><th>Tables</th></tr>";
            data.forEach(function (t) {
                htmlString += "<tr onclick='getTables()'><td>" + t + "</td>";
            });
            htmlString += "</table>";
            $("#tables").append(htmlString);
        }
    })
    $("#tables").show();
}
