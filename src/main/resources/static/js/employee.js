$("#employeeAddForm").submit(function (event) {
    event.preventDefault();
    ajaxPost();
});

$("#employeeEditForm").submit(function (event) {
    event.preventDefault();
    ajaxPut();
});

$("#deleteButton").click(function (event) {
    event.preventDefault();
    ajaxDelete();
});

function ajaxPost() {
    var departmentId = $("#department").val();

    if (departmentId === '' || departmentId === undefined) {
        departmentId = null;
    } else {
        departmentId = {
            id: Number(departmentId)
        }
    }

    var formData = {
        firstName: $("#firstName").val(),
        lastName: $("#lastName").val(),
        department: departmentId,
        jobTitle: $("#jobTitle").val(),
        gender: $("#gender").val(),
        birthDate: $("#birthDate").val()
    }

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/api/employee/add",
        data: JSON.stringify(formData),
        dataType: 'json'
    }).always(function (jqXHR, textStatus) {
        if (jqXHR.status === 200) {
            $("#postResultDiv").html("Employee successfully created!");
        } else {
            $("#postResultDiv").html("Error!");
        }
    })

    resetData();
}

function ajaxPut() {

    var employeeId = $("#employeeId").val();
    var departmentId = $("#department").val();

    if (departmentId === '' || departmentId === undefined) {
        departmentId = null;
    } else {
        departmentId = {
            id: Number(departmentId)
        }
    }

    var formData = {
        id: employeeId,
        firstName: $("#firstName").val(),
        lastName: $("#lastName").val(),
        department: departmentId,
        jobTitle: $("#jobTitle").val(),
        gender: $("#gender").val(),
        birthDate: $("#birthDate").val()
    }

    $.ajax({
        type: "PUT",
        contentType: "application/json",
        url: "/api/employee/" + employeeId,
        data: JSON.stringify(formData),
        dataType: 'json'
    }).always(function (jqXHR, textStatus) {
        if (jqXHR.status === 200) {
            $("#postResultDiv").html("Employee info successfully updated!");
        } else {
            $("#postResultDiv").html("Error!");
        }
    })
}

function ajaxDelete() {
    var employeeId = $("#employeeId").val();

    $.ajax({
        type: "DELETE",
        contentType: "application/json",
        url: "/api/employee/" + employeeId,
        data: employeeId,
        dataType: 'number'
    }).always(function (jqXHR, textStatus) {
        if (jqXHR.status === 200) {
            alert('Employee successfully deleted!');
            document.location.href = "/";
        } else {
            $("#postResultDiv").html("Error!");
        }
    })
}

function resetData() {
    $("#firstName").val("");
    $("#lastName").val("");
    $("#jobTitle").val("");
    $('#emptyDep').attr('selected', 'true');
    $('#maleOption').attr('selected', 'true');
    $("#birthDate").val("");
}

$("#enableDisable").click(function () {
    if ($('#firstName').attr('disabled') != null) {
        $('#firstName').removeAttr('disabled');
        $('#lastName').removeAttr('disabled');
        $('#department').removeAttr('disabled');
        $('#jobTitle').removeAttr('disabled');
        $('#gender').removeAttr('disabled');
        $('#birthDate').removeAttr('disabled');

        $('#saveButton').removeAttr('disabled');
    } else {
        $('#firstName').attr('disabled', 'disabled');
        $('#lastName').attr('disabled', 'disabled');
        $('#department').attr('disabled', 'disabled');
        $('#jobTitle').attr('disabled', 'disabled');
        $('#gender').attr('disabled', 'disabled');
        $('#birthDate').attr('disabled', 'disabled');

        $('#saveButton').attr('disabled', 'disabled');
    }
});



