package com.gentera.yastas.sdk.myapplication.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.gentera.yastas.sdk.myapplication.data.models.DtoSuperHero
import com.gentera.yastas.sdk.myapplication.databinding.FragmentDetailSuperHeroBinding

class DetailSuperHeroFragment : Fragment() {

    private lateinit var binding: FragmentDetailSuperHeroBinding
    private var dtoSuperHero: DtoSuperHero = DtoSuperHero()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {args->
            dtoSuperHero = args.getSerializable("dtoSuperHero") as DtoSuperHero
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailSuperHeroBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(requireContext()).load(dtoSuperHero.image.url).skipMemoryCache(true).into(binding.ivPictureHeader)
        Glide.with(requireContext()).load(dtoSuperHero.image.url).skipMemoryCache(true).into(binding.ivPictureCircle)
        binding.tvName.text = dtoSuperHero.name
        binding.tvOcupation.text = dtoSuperHero.id

        //PowerStats
        binding.tvIntelligence.text = "Inteligencia: ${dtoSuperHero.powerstats.intelligence}"
        binding.tvStrength.text = "Fuerza: ${dtoSuperHero.powerstats.strength}"
        binding.tvSpeed.text = "Velocidad: ${dtoSuperHero.powerstats.speed}"
        binding.tvDurability.text = "Resistencia: ${dtoSuperHero.powerstats.durability}"
        binding.tvPower.text = "Poder: ${dtoSuperHero.powerstats.power}"
        binding.tvCombat.text = "Combate: ${dtoSuperHero.powerstats.combat}"

        //Biography
        binding.tvFullName.text = "Nombre completo: ${dtoSuperHero.biography.fullName}"
        binding.tvAlterEgos.text = "Alter ego: ${dtoSuperHero.biography.alterEgos}"
        binding.tvAliases.text = "Alias: ${dtoSuperHero.biography.aliases}"
        binding.tvPlaceOfBirth.text = "Lugar de nacimiento: ${dtoSuperHero.biography.placeOfBirth}"
        binding.tvFirstAppearance.text = "Primera aparición: ${dtoSuperHero.biography.firstAppearance}"
        binding.tvPublisher.text = "Editorial: ${dtoSuperHero.biography.publisher}"
        binding.tvAlignment.text = "Alineación: ${dtoSuperHero.biography.alignment}"

        //Appearance
        binding.tvGender.text = "Género: ${dtoSuperHero.appearance.gender}"
        binding.tvRace.text = "Raza: ${dtoSuperHero.appearance.race}"
        binding.tvHeight.text = "Altura: ${dtoSuperHero.appearance.height}"
        binding.tvWeight.text = "Peso: ${dtoSuperHero.appearance.weight}"
        binding.tvEyeColor.text = "Color de los ojos: ${dtoSuperHero.appearance.eyeColor}"
        binding.tvHairColor.text = "Color de cabello: ${dtoSuperHero.appearance.hairColor}"

        //Work
        binding.tvOccupation.text = "Ocupación: ${dtoSuperHero.work.occupation}"
        binding.tvBase.text = "Base: ${dtoSuperHero.work.base}"

        //Connections
        binding.tvGroupAffiliation.text = "Grupo Afiliación: ${dtoSuperHero.connections.groupAffiliation}"
        binding.tvRelatives.text = "Parientes: ${dtoSuperHero.connections.relatives}"


    }
}