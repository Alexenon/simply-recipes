<?php
// AddRecipeView.php

class AddRecipeView {
    private ... ... $categoryService;
    private $recipeManagementService;

    public function __construct($categoryService, $recipeManagementService) {
        $this->categoryService = $categoryService;
        $this->recipeManagementService = $recipeManagementService;
    }

    public function render() {
        ?>
        <!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Add Recipe</title>
            <!-- Include any necessary CSS or JavaScript files here -->
        </head>
        <body>
            <h2>Add a New Recipe</h2>
            <form action="process_recipe.php" method="post">
                <label for="recipeTitle">Recipe Title:</label><br>
                <input type="text" id="recipeTitle" name="recipeTitle"><br>
                <label for="recipeDescription">Description:</label><br>
                <textarea id="recipeDescription" name="recipeDescription"></textarea><br>
                <label for="category">Categories:</label><br>
                <select id="category" name="category[]" multiple>
                    <?php
                    $categories = $this->categoryService->getAllCategories();
                    foreach ($categories as $category) {
                        echo "<option value='{$category->getId()}'>{$category->getName()}</option>";
                    }
                    ?>
                </select><br>
                <label for="recipePreparingDuration">Preparation time (in minutes):</label><br>
                <input type="number" id="recipePreparingDuration" name="recipePreparingDuration"><br>
                <label for="recipeCookingDuration">Cooking duration (in minutes):</label><br>
                <input type="number" id="recipeCookingDuration" name="recipeCookingDuration"><br>
                <!-- Include the ingredient uploader and cooking step uploader components here -->
                <input type="submit" value="Save recipe">
            </form>
        </body>
        </html>
        <?php
    }
}
?>
