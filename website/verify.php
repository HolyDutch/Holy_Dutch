<?php
session_start();
$DATABASE_HOST = 'localhost';
$DATABASE_USER = 'root';
$DATABASE_PASS = '';
$DATABASE_NAME = 'verify';
$connection = mysqli_connect($DATABASE_HOST, $DATABASE_USER, $DATABASE_PASS, $DATABASE_NAME);
if (mysqli_connect_errno()) {
    exit('Failed to connect to MySQL: ' . mysqli_connect_errno());
}
if (!isset($_SESSION['username'], $_SESSION['password'])) {
    header('Location: homepage.php');
}

if ($_SERVER['REQUEST_METHOD'] == 'POST' && isset($_POST['verify'])) {
    $ticket = $_POST['ticket'];
    $stmt = $connection->prepare('SELECT id FROM ticket WHERE ticket=?');
    $stmt->bind_param('s', $ticket);
    $stmt->execute();
    $stmt->store_result();
    if ($stmt->num_rows > 0) {
        $stmt->bind_result($id, $ticket);
        $stmt->fetch();
        if ($_POST['ticket'] === $ticket) {
            session_regenerate_id();
            $_SESSION['loggedin'] = TRUE;
            $_SESSION['name'] = $_POST['ticket'];
            $_SESSION['id'] = $id;
            header('Location: valid.html');
        } else {
            $error = 'Invalid code';
        }
    } else {
        $error = 'Invalid code';
    }
    $stmt->close();
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Verification Page</title>
</head>
<body>
    <h1>Verification Page</h1>
    <?php if (isset($error)) { ?>
        <p style="color: red;"><?php echo $error; ?></p>
    <?php } ?>
    <form method="post" action="">
        <label for="ticket">Enter Code:</label>
        <input type="text" name="ticket" id="ticket">
        <input type="submit" name="verify" value="Verify">
    </form>
</body>
</html>
