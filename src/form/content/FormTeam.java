package form.content;

import arc.graphics.Color;
import mindustry.game.Team;


public class FormTeam {
    public static Team sievers;

    public static void load() {
        sievers = newTeam(5, "sievers", Color.valueOf("27afb6"));
    }

    private static Team newTeam(int id, String name, Color color) {
        Team team = Team.get(id);
        team.name = name;
        team.color.set(color);

        team.palette[0] = color;
        team.palette[1] = color.cpy().mul(0.75f);
        team.palette[2] = color.cpy().mul(0.5f);

        for(int i = 0; i < 3; i++){
            team.palettei[i] = team.palette[i].rgba();
        }

        return team;

    }
    public String coloredName(int id, Color color){
        Team team = Team.get(id);
        team.color.set(color);
        return team.emoji + "[#" + color + "]" + team.localized() + "[]";
    }
}
