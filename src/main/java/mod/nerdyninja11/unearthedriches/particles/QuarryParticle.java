package mod.nerdyninja11.unearthedriches.particles;

import java.util.Locale;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import mod.nerdyninja11.unearthedriches.init.ParticleInit;
import net.minecraft.client.particle.IAnimatedSprite;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.IParticleRenderType;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.SpriteTexturedParticle;
import net.minecraft.network.PacketBuffer;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleType;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class QuarryParticle extends SpriteTexturedParticle {

	//private double posX, posY, posZ;
	private float angle;

	public QuarryParticle(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn,
			double ySpeedIn, double zSpeedIn, QuarryParticleData data, IAnimatedSprite sprite) {
		super(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeedIn, ySpeedIn, zSpeedIn);

		this.motionX = xSpeedIn;
		this.motionY = ySpeedIn;
		this.motionZ = zSpeedIn;
		this.posX = xCoordIn;
		this.posY = yCoordIn;
		this.posZ = zCoordIn;
		this.particleScale = 0.3f * (this.rand.nextFloat() + 2.5f);
		
		float f = (float) Math.random() * 0.4F + 0.6F;
		this.particleRed = ((float) (Math.random() * (double) 0.1F) + 0.8F) * data.getRed() * f;
		this.particleGreen = ((float) (Math.random() * (double) 0.1F) + 0.8F) * data.getGreen() * f;
		this.particleBlue = ((float) (Math.random() * (double) 0.1F) + 0.8F) * data.getBlue() * f;
		this.maxAge = (int) (Math.random() * 10.0D) + 30;
	}

	@Override
	public void tick() {
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		if (this.age++ >= this.maxAge) {
			this.setExpired();
		} else {
	         this.motionX += (double)(0.6F * MathHelper.cos(this.angle));
	         this.motionZ += (double)(0.6F * MathHelper.sin(this.angle));
	         this.motionX *= 0.07D;
	         this.motionZ *= 0.07D;
	         this.move(this.motionX, this.motionY, this.motionZ);


	         this.angle = (float)((double)this.angle + 0.3D);
	      }
	}

	@Override
	public IParticleRenderType getRenderType() {
		return IParticleRenderType.PARTICLE_SHEET_OPAQUE;
	}

	@OnlyIn(Dist.CLIENT)
	public static class Factory implements IParticleFactory<QuarryParticleData> {
		private final IAnimatedSprite spriteSet;

		public Factory(IAnimatedSprite spriteIn) {
			this.spriteSet = spriteIn;
		}

		public Particle makeParticle(QuarryParticleData typeIn, World worldIn, double x,
				double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			QuarryParticle particle = new QuarryParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, typeIn,
					spriteSet);
			particle.selectSpriteRandomly(spriteSet);
			return particle;
		}

	}

	public static class QuarryParticleData implements IParticleData {
		public static final IParticleData.IDeserializer<QuarryParticleData> DESERIALIZER = new IParticleData.IDeserializer<QuarryParticleData>() {

			public QuarryParticleData deserialize(ParticleType<QuarryParticleData> particleTypeIn,
					StringReader reader) throws CommandSyntaxException {
				reader.expect(' ');
				float red = (float) reader.readDouble();
				reader.expect(' ');
				float green = (float) reader.readDouble();
				reader.expect(' ');
				float blue = (float) reader.readDouble();
				reader.expect(' ');
				float alpha = (float) reader.readDouble();
				return new QuarryParticleData(red, green, blue, alpha);
			}
			
			public QuarryParticleData read(ParticleType<QuarryParticleData> particleTypeIn, PacketBuffer buffer) {
				return new QuarryParticleData(buffer.readFloat(), buffer.readFloat(), buffer.readFloat(),
						buffer.readFloat());
			}
		};
		private final float red;
		private final float green;
		private final float blue;
		private final float alpha;
		
		public QuarryParticleData(float redIn, float greenIn, float blueIn, float alphaIn) {
			this.red = redIn;
			this.green = greenIn;
			this.blue = blueIn;
			this.alpha = MathHelper.clamp(alphaIn, 0.01F, 4.0F);
			
		}
		
		@Override
		public void write(PacketBuffer buffer) {
			buffer.writeFloat(this.red);
			buffer.writeFloat(this.green);
			buffer.writeFloat(this.blue);
			buffer.writeFloat(this.alpha);
		}


		@SuppressWarnings("deprecation")
		@Override
		public String getParameters() {
			return String.format(Locale.ROOT, "%s %.2F %.2F %.2F %.2F", Registry.PARTICLE_TYPE.getKey(this.getType()),
					this.red, this.green, this.blue, this.alpha);
			
		} 
		
		@Override
		public ParticleType<QuarryParticleData> getType() {
			return ParticleInit.QUARRY_PARTICLE.get();
		}
		
		@OnlyIn(Dist.CLIENT)
		public float getRed() {
			return this.red;
		}

		@OnlyIn(Dist.CLIENT)
		public float getGreen() {
			return this.green;
		}
		
		@OnlyIn(Dist.CLIENT)
		public float getBlue() {
			return this.blue;
		}
		
		@OnlyIn(Dist.CLIENT)
		public float getAlpha() {
			return this.alpha;
		}
	}
}
