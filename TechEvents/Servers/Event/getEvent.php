<?php header('Access-Control-Allow-Origin: *'); ?>
<?php 
require_once('connect.php'); 
      $query_search = "SELECT idEvent,titre,description,capaciteMax,capaciteMin,dateEvent,duree,photoPath,statut FROM `evenement`";  
      $jsontext = "[";
      $stmt1 = $pdo->query($query_search, PDO::FETCH_OBJ);
			foreach($stmt1->fetchAll() as $row) {
				$jsontext .="{";
				foreach($row as $key => $value) {
	    			$jsontext .= '"'.addslashes($key).'": "'.addslashes($value).'",';
					}
					$jsontext = substr_replace($jsontext, '', -1);
					$jsontext .="},";
	}
	$jsontext = substr_replace($jsontext, '', -1);
	$jsontext .= "]";
	echo $jsontext;

?>
