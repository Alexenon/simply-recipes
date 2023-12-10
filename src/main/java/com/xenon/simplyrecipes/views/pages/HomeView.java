package com.xenon.simplyrecipes.views.pages;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.xenon.simplyrecipes.views.MainLayout;

/*
https://codepen.io/__dd__/pen/ZJyGEV
*/

@PageTitle("Home")
@Route(value = "", layout = MainLayout.class)
@CssImport("./themes/my-theme/css/home-page.css")
public class HomeView extends Main {

    public HomeView() {
        add(
                getHomeSection()
//                getContactSection()
        );
    }

    private Html getHomeSection() {
        return new Html("""
                    <section id="home" class="container-fluid text-center">
                        <h1>Home</h1>
                        <small class="title-element">is where the</small>
                        <span class="heart title-element">heart</span>
                        <small class="title-element"> is. </small>
                    </section>
                """);
    }

    private Html getContactSection() {
        return new Html("""
                <section id="contact" class="container-fluid text-center">
                   <h1>Catch me <small><br><span class="heart"> if you can... </span> </small></h1>
                     <ul class="catch">
                       <li>s
                         <a class="fa fa-code" href="https://www.sololearn.com/Profile/2251477" target="_blank"></a>
                       </li> s
                       <li>
                         <a class="fa fa-fire" href="https://www.freecodecamp.org/" target="_blank"></a>
                       </li>
                       <li>
                         <a class="fa fa-codepen" href="https://codepen.io/" target="_blank"></a>
                       </li>
                     </ul>
                 </section>
                 """);
    }

}
