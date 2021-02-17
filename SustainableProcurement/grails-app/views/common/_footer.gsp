<!DOCTYPE html>
<html>

<style>
.footer {
    position: fixed;
    left: 0;
    bottom: 0;
    width: 100%;
    color: white;
    text-align: center;
}
</style>

<footer>
    <sec:ifNotGranted roles="ROLE_ADMIN">
        <div class="footer w3-container w3-green" align="center">
            <tr>
                <td>
                    Have questions or need help?
                    Email <a href="mailto:sustainable.procurement@gmail.com">sustainable.procurement@gmail.com</a>
                </td>
            </tr>
        </div>
    </sec:ifNotGranted>
</footer>

</html>
