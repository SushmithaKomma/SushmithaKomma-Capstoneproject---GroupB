<!DOCTYPE html>
<html>
<title>Sustainable Procurement: View Accounts</title>
<meta name="viewport" content="wide-device-width, initial-scale=1">
<asset:stylesheet src="w3.css"/>
<head>

    <g:render template="/common/header"/>

</head>
<style>
.table_wrapper{
    display: block;
    overflow-x: auto;
    white-space: nowrap;
}
</style>

<body>
<script>
    function myFunction() {
        // Declare variables
        var input, filter, table, tr, td, i, txtValue;
        input = document.getElementById("myInput");
        filter = input.value.toUpperCase();
        table = document.getElementById("myTable");
        tr = table.getElementsByTagName("tr");

        // Loop through all table rows, and hide those who don't match the search query
        for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[0];
            if (td) {
                txtValue = td.textContent || td.innerText;
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    tr[i].style.display = "";
                } else {
                    tr[i].style.display = "none";
                }
            }
        }
    }
</script>

<div class="w3-center">
    <strong>Supplier Accounts</strong>
</div>

<br>

<g:form >
    <table class="w3-border w3-border-blue" align="center">
        <tr>
            <th class="w3-blue"> Filter Accounts</th>
            <td>
                <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for names..">
            </td>
        </tr>
    </table>
</g:form>

<br>

<div class="w3-center">
    <g:link class="w3-button w3-border w3-pale-blue w3-round" controller="Home" action="index">
        Home
    </g:link>
</div>
<br>
<div class="table_wrapper">
<table class="w3-border w3-border-blue w3-striped table" align="center" id="myTable">
    <g:if test="${!allUserNames}">
        <tr>
            <td align="center">
                (None)
            </td>
        </tr>
    </g:if>
    <g:else>
        <thead>
        <tr>
            <th class="w3-blue" onclick="sortTable(0)">User Name</th>
            <th class="w3-blue" >Account</th>
            <th class="w3-blue" >Logins</th>
        </tr>
        </thead>
        <g:each in="${allUserNames}" var="dataPoint" status="i">
                <tbody>
            <tr class="w3-center">
                <td>
                    ${allUserNames[i]}
                </td>
                <td>
                    <g:link class="w3-button w3-border w3-pale-blue w3-round" action="editAccount"
                            params="[oldUsername: allUserNames[i]]">Modify</g:link>
                </td>

            </tr>
                </tbody>
        </g:each>
    </g:else>
</table>
</div>

<div class="w3-center">
    <strong>Administrator Accounts</strong>
</div>

<table class="w3-border w3-border-blue w3-striped" align="center">
    <g:if test="${!allAdminNames}">
        <tr>
            <td align="center">
                (None)
            </td>
        </tr>
    </g:if>
    <g:else>
        <tr>
            <th class="w3-blue">Admin Name</th>
            <th class="w3-blue">Account</th>
        </tr>
        <g:each in="${allAdminNames}" var="dataPoint" status="i">
            <tr class="w3-center">
                <td>
                    ${allAdminNames[i]}
                </td>
                <td>
                    <g:link class="w3-button w3-border w3-pale-blue w3-round" action="editAccount"
                            params="[oldUsername: allAdminNames[i]]">Modify</g:link>
                </td>
            </tr>
        </g:each>
    </g:else>
</table>

<br><br><br>


</body>

<footer>
    <g:render template="/common/footer"/>
</footer>

</html>
