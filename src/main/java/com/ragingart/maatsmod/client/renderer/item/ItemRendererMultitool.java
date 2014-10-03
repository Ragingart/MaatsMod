package com.ragingart.maatsmod.client.renderer.item;

import com.ragingart.maatsmod.client.renderer.model.ModelMultitool;
import com.ragingart.maatsmod.ref.Models;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

/**
 * Created by MaaT on 08.09.2014.
 */
public class ItemRendererMultitool implements IItemRenderer {

    protected ModelMultitool tool;

    public ItemRendererMultitool(){
        tool = new ModelMultitool();
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        switch(type){
            case EQUIPPED:
                return true;
            case EQUIPPED_FIRST_PERSON:
                return true;
            case INVENTORY:
                return true;
            case ENTITY:
                return true;
            default:
                return false;
        }
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        switch(type){
            case EQUIPPED:
                GL11.glPushMatrix();

                Minecraft.getMinecraft().renderEngine.bindTexture(Models.Multitool);

                GL11.glScalef(1.8F,1.8F,1.8F);
                GL11.glRotatef(135.0F,0.0F,1.0F,0.0F);
                GL11.glRotatef(180.0F,1.0F,0.0F,0.0F);
                GL11.glRotatef(20.0F,0.0F,0.0F,-1.0F);
                GL11.glTranslatef(0.2F,-0.5F,0.0F);
                tool.render((Entity)data[1],0.0625F);

                GL11.glPopMatrix();
                break;
            case EQUIPPED_FIRST_PERSON:
                GL11.glPushMatrix();
                Minecraft.getMinecraft().renderEngine.bindTexture(Models.Multitool);
                GL11.glScalef(1.8F,1.8F,1.8F);
                GL11.glRotatef(50.0F,0.0F,1.0F,0.0F);
                GL11.glRotatef(180.0F,1.0F,0.0F,0.0F);
                GL11.glRotatef(65.0F,0.0F,0.0F,-1.0F);
                GL11.glTranslatef(1.0F,0.2F,-0.9F);

                tool.render((Entity)data[1],0.0625F);
                GL11.glPopMatrix();
                break;
            case INVENTORY:

                GL11.glPushMatrix();

                Minecraft.getMinecraft().renderEngine.bindTexture(Models.Multitool);

                GL11.glRotatef(180, -1.0F, 0.0F, 0.0F);
                GL11.glRotatef(180,0,1,0);
                //GL11.glScalef(0.5F, 0.5F, 0.5F);
                tool.render(null,0.0625F);

                GL11.glPopMatrix();
                break;
            case ENTITY:

                GL11.glPushMatrix();

                Minecraft.getMinecraft().renderEngine.bindTexture(Models.Multitool);

                GL11.glRotatef(180, -1.0F, 0.0F, 0.0F);
                //GL11.glScalef(0.5F, 0.5F, 0.5F);

                tool.render(null,0.0625F);

                GL11.glPopMatrix();
                break;
            default:
                break;
        }
    }
}