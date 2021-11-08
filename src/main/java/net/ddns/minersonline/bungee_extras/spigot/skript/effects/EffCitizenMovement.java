package net.ddns.minersonline.bungee_extras.spigot.skript.effects;

import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Name;
import ch.njol.skript.doc.RequiredPlugins;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;
import org.bukkit.event.Event;

import javax.annotation.Nullable;
import java.util.Objects;


@Name("Pause and un pause Citizens")
@Description({"Pause and un pause Citizens by:",
        "* ID",
        "This will make a given NPC pause / unpause at his location"})
@RequiredPlugins("Citizens")
public class EffCitizenMovement extends Effect
{
    private Expression<Number> id;
    private Expression<Boolean> doMove;

    @Override
    protected void execute(Event event) {
        NPCRegistry registry = CitizensAPI.getNPCRegistry();
        NPC npc = registry.getById(Objects.requireNonNull(id.getSingle(event)).intValue());
        npc.getNavigator().setPaused(doMove.getSingle(event).booleanValue());
    }

    @Override
    public String toString(@Nullable Event event, boolean b) {
        return null;
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        id = (Expression<Number>) expressions[0];
        doMove = (Expression<Boolean>) expressions[1];
        return true;
    }
}
