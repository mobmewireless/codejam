<html>
	<head>
		<script language="javascript" type="text/javascript" src="jquery.js"></script>
	</head>
	<body>

		<p>
			Please open pages in this order:</br>1.
			<a href="index.php" target="_blank">Home page</a></br>2.
			<a href="filter.php" target="_blank">Filter Page</a></br>3.
			<a href="count.php" target="_blank">Counting page</a>. Keep all the pages open at the same time and you can see the realtime data.
		</p>
		<div id="output">
			Random 10 digit numbers: Updated every 1 second, and is stored in a text file "testFile.txt".
		</div>

		<script id="source" language="javascript" type="text/javascript">
			$( function () {

				$.ajax({
					url: 'delete_contents.php',
					data: "",

					dataType: 'json',
				});
			});
			$( setInterval( function () {
				$.ajax({
					url: 'api.php',
					data: "",

					dataType: 'json',
					success: function(data) {
						var id = data;

						$('#output').append("<p>"+id+"</p>");
					}
				});
			},1000));
		</script>
	</body>
</html>