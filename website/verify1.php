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

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    if (isset($_POST['code'])) {
        $code = mysqli_real_escape_string($connection, $_POST['code']);

        // Prepare and execute the SELECT query
        if ($stmt = $connection->prepare('SELECT id FROM ticket WHERE ticket = ?')) {
            $stmt->bind_param('s', $code);
            $stmt->execute();
            $stmt->store_result();
            if ($stmt->num_rows > 0) {
                // Code exists in the database
                $stmt->bind_result($id);
                $stmt->fetch();
                session_regenerate_id();
                $_SESSION['loggedin'] = true;
                $_SESSION['name'] = $code;
                $_SESSION['id'] = $id;
                header('Location: valid.html');
                exit;
            } else {
                // Code does not match
                echo "Invalid code";
            }
            $stmt->close();
        }
    } else {
        echo "Please enter a code";
    }
}

mysqli_close($connection);
?>
