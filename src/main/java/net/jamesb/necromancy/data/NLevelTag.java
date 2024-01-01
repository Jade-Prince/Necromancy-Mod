package net.jamesb.necromancy.data;

import com.mojang.logging.LogUtils;
import net.minecraft.nbt.StreamTagVisitor;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.TagType;
import net.minecraft.nbt.TagVisitor;
import org.slf4j.Logger;

import java.io.DataOutput;
import java.io.IOException;

public class NLevelTag implements Tag {

    private static final Logger LOGGER = LogUtils.getLogger();

    private int level;
    private int levelXP;

    public NLevelTag(int _level, int _levelXP)
    {
        this.level = _level;
        this.levelXP = _levelXP;
    }

    @Override public void write(DataOutput pOutput) throws IOException {
        pOutput.writeInt(this.level);
    }
    @Override public String toString() {
        return "Level: " + this.level + ", XP: " + this.levelXP;
    }
    @Override public byte getId() {
        return 11;
    }
    @Override public TagType<?> getType() {
        return null;
    }
    @Override public NLevelTag copy() {
        return this;
    }
    @Override public int sizeInBytes() {
        return 24 + 4 * 2;
    }
    @Override public void accept(TagVisitor pVisitor) {

    }

    @Override public StreamTagVisitor.ValueResult accept(StreamTagVisitor pVisitor) {
        return pVisitor.visit(new int[]{this.level, this.levelXP});
    }

    public void levelUp(int _add)
    {
        for (int i = 0; i <= _add; i++)
        {
            levelUp();
        }
    }
    public void levelUp()
    {
        this.levelXP++;
        LOGGER.debug("XP leveled up to " + this.levelXP);
//        checkValues(); causes infinite loop?!
    }

    private void checkValues()
    {
        if (this.levelXP >= 10 * this.level)
        {
            this.levelXP -= 10 * this.level;
            this.level++;
            LOGGER.debug("Leveled up to " + this.level);
            checkValues();
        }
    }
}
