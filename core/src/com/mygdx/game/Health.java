package com.mygdx.game;

import java.util.ArrayList;
import com.mygdx.game.Professor.Stat;
import com.mygdx.game.Professor.Resource;

public class Health {
    private static ArrayList<Executable> healthEvents;
    private static ArrayList<Executable> engagementEvents;
    static{
        healthEvents = new ArrayList<Executable>();
        engagementEvents = new ArrayList<Executable>();

        healthEvents.add(new Event("You catch a cold.",
                new Option("Go to class sick.", new ResourceCost(Resource.YERBA, 1), "You only finished half your slides before losing your voice.", new StatChange(Stat.HEALTH, -15), new StatChange(Stat.ENGAGEMENT, -5), new StatChange(Stat.HUMOR, 5)),
                new Option("Cancel class.", "You take a sick, but you're behind on lectures.", new StatChange(Stat.HEALTH, 10), new StatChange(Stat.EASINESS, -5), new ResourceChange(Professor.Resource.CHALK, 1)),
                new Option("Get a guest lecturer.", new Event("Pick a lecturer to substitute",
                        new Option("Noah Mitchell", "Noah educates the students very well.", new StatChange(Stat.HUMOR, 5), new StatChange(Stat.HEALTH, 15)),
                        new Option("Hongmin Wang", new ResourceCost(Resource.TA, 1), "He sees he makes a mistake.", new StatChange(Stat.EASINESS, 5), new StatChange(Stat.HEALTH, 15)),
                        new Option("Richert Wang", "The students learn Java in a C++ class.", new StatChange(Stat.ENGAGEMENT, -5), new StatChange(Stat.HEALTH, 15))))
                ));
        healthEvents.add(new Event("A fire breaks out near Santa Barbara.",
                new Option("Continue class.", "You decide the fire is not enough to stop education", new StatChange(Stat.HEALTH, -10), new StatChange(Stat.ACCESSIBILITY, 5), new Event("The fires rage on.",
                        new Option("Keep continuing class", "Why?", new StatChange(Stat.HEALTH, -20)),
                        new Option("Leave. Now.", "Most of your class makes it out alive.", new StatChange(Stat.HEALTH, 10), new StatChange(Stat.HUMOR, -10)))),
                new Option("Run out of the classroom screaming.", "Your abandon your students and make a fool out of yourself", new StatChange(Stat.HUMOR, 10))
                ));
        healthEvents.add(new Event("A student says hi to you during a department-hosted run.",
                new Option("Say hi back.", "You had a good conversation with student.", new StatChange(Stat.ACCESSIBILITY, 10)),
                new Option("Ignore student.", "You embarrassed the student, but you floored the student during the run.", new StatChange(Stat.ACCESSIBILITY, -10), new StatChange(Stat.HEALTH, 10))));


        engagementEvents.add(new Event("Your student has a crush on you and hits on you.",
                new Option("Are seduced.", "You are distracted during class.", new StatChange(Stat.ENGAGEMENT,-10), new StatChange(Stat.HEALTH, -20)),
                new Option("Politely turn down the student.", "This was uncomfortable.", new StatChange(Stat.ENGAGEMENT, -5), new StatChange(Stat.HEALTH, 10)),
                new Option( "Ask a TA to turn the student down for you.", new ResourceCost(Resource.TA,1), "SOS. Maybe you should hold shorter office hours.", new StatChange(Stat.ENGAGEMENT, -5), new StatChange(Stat.ACCESSIBILITY, -5))));

        engagementEvents.add(new Event("Wifi is down in the middle of the class.",
                new Option("Teach the class on the chalkboard.", new ResourceCost(Resource.CHALK, 1), "Your hand hurts.", new StatChange(Stat.HEALTH, -5), new StatChange(Stat.ENGAGEMENT, 10)),
                new Option("Teach the class without any visuals.", new StatChange(Stat.ENGAGEMENT, -10))));

        engagementEvents.add(new Event("You take a break from lecture.",
                new Option("Give the students a pop quiz", new StatChange(Stat.ENGAGEMENT,15), new StatChange(Stat.HUMOR, -10)),
                new Option("Have the students do a group activity.", new StatChange(Stat.ENGAGEMENT,10))));
    }
}
