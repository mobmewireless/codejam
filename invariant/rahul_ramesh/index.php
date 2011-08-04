<?php
require "includes/functions.php";
require "includes/main.php";
?>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
	<title>Charting</title>
	<link href="styles/css/basic.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript" src="scripts/_shared/EnhanceJS/enhance.js"></script>		
	<script type="text/javascript">
		// Run capabilities test
		enhance({
			loadScripts: [
				'scripts/js/excanvas.js',
				'scripts/_shared/jquery.min.js',
				'scripts/js/visualize.jQuery.js',
				'scripts/js/example.js'
			],
			loadStyles: [
				'styles/css/visualize.css',
				'styles/css/visualize-light.css'
			]	
		});   
    </script>
</head>
<body>

<table>
	<caption>Number of iterations and total count of each</caption>
	<thead>
		<tr>
			<th scope="col">Iteration</th>
			<th scope="col">Total count of numbers</th>
		</tr>
	</thead>
	<tbody>
		<?php
			table_create($iterations, $iterations_map);
		?>		
	</tbody>
</table>	
</body>
</html>

