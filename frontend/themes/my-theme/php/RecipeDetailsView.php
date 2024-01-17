<?php
// RecipeDetailsView.php

class RecipeDetailsView implements HasUrlParameter<Long> {
    private static $FOLDER_LOCATION = "./recipe-images/";

    private $recipeService;
    private $commentService;

    public function setParameter(BeforeEvent $event, Long $recipeId) {
        $this->recipe = $this->recipeService->getRecipeById($recipeId)
            ->orElseThrow(() -> new RuntimeException("Recipe not found"));

        $this->initialize();
        $this->getElement()->executeJs("window.scrollTo(0,0)");
    }

    private function initialize() {
        echo "<div class='recipe-details'>";
        echo $this->getHeader()->render();
        echo $this->getImage()->render();
        echo $this->getDescription()->render();
        echo $this->getInformationSection()->render();
        echo $this->getIngredientSection()->render();
        echo $this->getCookingStepSection()->render();
        echo $this->getCommentSection()->render();
        echo "</div>";
    }

    private function getHeader() {
        return "<h2 class='recipe-header'>" . $this->recipe->getName() . "</h2>";
    }

    private function getDescription() {
        return "<div class='container'><p>" . $this->recipe->getDescription() . "</p></div>";
    }

    private function getImage() {
        return "<img src='" . self::$FOLDER_LOCATION . $this->recipe->getImageName() . "' alt='" . $this->recipe->getImageName() . "' class='recipe-image'>";
    }

    private function getInformationSection() {
        $mins = " minutes";
        $html = "<ul class='details-layout'>";
        $html .= $this->getListItem("PREP TIME", $this->recipe->getPreparingDuration() . $mins);
        $html .= $this->getListItem("COOK TIME", $this->recipe->getCookingDuration() . $mins);
        $html .= "</ul>";
        return $html;
    }

    private function getIngredientSection() {
        $html = "<div class='ingredients-layout'>";
        $html .= "<h3>Ingredients</h3><hr>";
        $html .= "<ul>";
        foreach ($this->recipe->getIngredients() as $ingredient) {
            $amount = strval($ingredient->getAmount());
            $html .= $this->getListItem($ingredient->getName(), $amount);
        }
        $html .= "</ul></div>";
        return $html;
    }

    private function getCookingStepSection() {
        $html = "<div class='cooking-steps-layout'>";
        $html .= "<h3>Cooking Steps</h3><hr>";
        $html .= "<ol>";
        foreach ($this->recipe->getCookingSteps() as $step) {
            $html .= "<li>" . $step->getStep() . "</li>";
        }
        $html .= "</ol></div>";
        return $html;
    }

    private function getListItem($title, $info) {
        return "<li><span>" . $title . "</span>" . $info . "</li>";
    }

}
