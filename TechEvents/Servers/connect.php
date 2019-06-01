
<?php  
$username = 'root';
$password = '';
$hostname = 'localhost';
$database = 'techeventdb';

try {
	$pdo = new PDO("mysql:host={$hostname};dbname={$database}", $username, $password);
	}
		catch(PDOException $e) {
			die("Could not connect to the database\n");
		}
 ?>
