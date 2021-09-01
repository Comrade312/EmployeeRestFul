$("#departmentAddForm").submit(function (event) {
    event.preventDefault();
    ajaxPost();
});

$("#departmentEditForm").submit(function (event) {
    event.preventDefault();
    ajaxPut();
});

$("#deleteButton").click(function (event) {
    event.preventDefault();
    ajaxDelete();
});


function ajaxPost() {
    var formData = {
        name: $("#name").val()
    }

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/api/department/add",
        data: JSON.stringify(formData),
        dataType: 'json'
    }).always(function (jqXHR, textStatus) {
        if (jqXHR.status === 200) {
            $("#postResultDiv").html("Department successfully created!");
        } else {
            $("#postResultDiv").html("Error!");
        }
    })

    resetData();
}

function ajaxPut() {
    var departmentId = $("#departmentId").val();

    var formData = {
        id: departmentId,
        name: $("#name").val()
    }

    $.ajax({
        type: "PUT",
        contentType: "application/json",
        url: "/api/department/" + departmentId,
        data: JSON.stringify(formData),
        dataType: 'json'
    }).always(function (jqXHR, textStatus) {
        if (jqXHR.status === 200) {
            $("#postResultDiv").html("Department info successfully update!");
        } else {
            $("#postResultDiv").html("Error!");
        }
    })
}

function ajaxDelete() {
    var departmentId = $("#departmentId").val();

    $.ajax({
        type: "DELETE",
        contentType: "application/json",
        url: "/api/department/" + departmentId,
        data: departmentId,
        dataType: 'number'
    }).always(function (jqXHR, textStatus) {
        if (jqXHR.status === 200) {
            alert('Department successfully deleted!');
            document.location.href = "/";
        } else {
            $("#postResultDiv").html("Error!");
        }
    })
}

function resetData() {
    $("#name").val("");
}

$("#enableDisable").click(function () {
    if ($('#name').attr('disabled') != null) {
        $('#name').removeAttr('disabled');
        $('#saveButton').removeAttr('disabled');
    } else {
        $('#name').attr('disabled', 'disabled');
        $('#saveButton').attr('disabled', 'disabled');
    }
});
