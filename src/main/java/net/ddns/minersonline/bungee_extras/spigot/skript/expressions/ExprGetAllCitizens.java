package net.ddns.minersonline.bungee_extras.spigot.skript.expressions;

import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Name;
import ch.njol.skript.doc.RequiredPlugins;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.event.Event;

import javax.annotation.Nullable;
import java.util.ArrayList;

@Name("Get all citizens")
@Description({"Used for:",
        "* Getting all citizens",
        "This will allow you to get all NPC's"})
@RequiredPlugins("Citizens")
public class ExprGetAllCitizens extends SimpleExpression<Number> {
    @Override
    public Class<? extends Number> getReturnType() {
        return Number.class;
    }

    @Override
    public boolean isSingle() {
        return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] exp, int arg1, Kleenean arg2, ParseResult arg3) {
        return true;
    }

    @Override
    public String toString(@Nullable Event arg0, boolean arg1) {
        return null;
    }


    @Override
    protected Number[] get(Event evt) {
        ArrayList<Number> list = new ArrayList<>();
        for (NPC npc : CitizensAPI.getNPCRegistry().sorted()) {
            list.add(npc.getId());
        }
        return list.toArray(Number[]::new);
    }

}