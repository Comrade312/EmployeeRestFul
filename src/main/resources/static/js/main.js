$('#employeeTable tr').dblclick(function () {
    document.location.href = "/employee/view/" + this.cells[0].innerHTML;
});

$('#departmentTable tr').dblclick(function () {
    document.location.href = "/department/view/" + this.cells[0].innerHTML;
});

