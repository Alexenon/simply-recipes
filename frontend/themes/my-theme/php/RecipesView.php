<?php
require_once 'vendor/autoload.php'; // Include the necessary autoload file

use com\xenon\simplyrecipes\entities\Recipe;
use com\xenon\simplyrecipes\services\CategoryService;
use com\xenon\simplyrecipes\services\RecipeService;
use com\xenon\simplyrecipes\views\MainLayout;
use com\xenon\simplyrecipes\views\components\RecipeCardLayout;

class RecipesView extends Main implements HasUrlParameter
{
    private $recipeService;
    private $categoryService;
    private $categoryName;

    public function __construct(RecipeService $recipeService, CategoryService $categoryService)
    {
        $this->recipeService = $recipeService;
        $this->categoryService = $categoryService;
    }

    public function setParameter(BeforeEvent $event, $categoryName)
    {
        $this->categoryName = $categoryName;
        $this->initialize();
    }

    private function initialize()
    {
        $this->addClassName("page-content");

        $wrapper = new Div();
        $wrapper->addClassName("recipe-wrapper");
        foreach ($this->getListOfRecipes() as $recipe) {
            $wrapper->add(new RecipeCardLayout($recipe));
        }

        $this->add($this->getPageTitle(), $wrapper);
    }

    private function getPageTitle()
    {
        $titleText = empty($this->categoryName) ? "Recipes" : $this->categoryName . " Recipes";
        $title = new H2($titleText);
        $title->addClassName("recipe-header");
        return $title;
    }

    private function getListOfRecipes()
    {
        return empty($this->categoryName) ? $this->recipeService->getAllRecipes() : $this->recipeService->getRecipesByCategory($this->categoryName);
    }
}
