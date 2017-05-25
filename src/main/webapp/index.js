$(document).ready(function() {

    $("#check").click(function () {
        $("#result").empty();
        $("#tables").hide();
        $("#columns").hide();
        $.ajax({
            url: "/query",
            type: "get",
            success: function (data) {
                console.log(data);
                var htmlString = "<table><tr><th>Shemas</th></tr>";
                data.forEach(function (t) {
                    htmlString += "<tr onclick='getTablesName()'><td>" + t + "</td>";
                });
                htmlString += "</table>";
            $("#result").append(htmlString);
            }
        })
        $("#result").show();
    })

});

function getTablesName() {

    $("#tables").empty();
    $("#result").hide();
    $("#columns").hide();
    var shemaName = $("td").val();
    $.ajax({
        url: "/table",
        type: "get",
        data: {"shema" : shemaName},
        success: function (data) {
            console.log(data);
            var htmlString = "<table><tr><th>Tables</th></tr>";
            data.forEach(function (t) {
                htmlString += "<tr onclick='getTable()'><td>" + t + "</td>";
            });
            htmlString += "</table>";
            $("#tables").append(htmlString);
        }
    })
    $("#tables").show();
}

function getTable() {

    $("#columns").empty();
    $("#result").hide();
    $("#tables").hide();
    var tableName = $("td").val();
    $.ajax({
        url: "/column",
        type: "get",
        data: {"table" : tableName},
        success: function (data) {
            console.log(data);

            var htmlString = "<table><tr><th>Columns</th></tr>";
            data.forEach(function (t) {
                htmlString += "<tr onclick='getTable()'><td>" + t + "</td>";
            });
            htmlString += "</table>";
            $("#columns").append(htmlString);
        }
    })
    $("#columns").show();
}
