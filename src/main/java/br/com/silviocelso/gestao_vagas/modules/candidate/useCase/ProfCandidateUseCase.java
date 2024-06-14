package br.com.silviocelso.gestao_vagas.modules.candidate.useCase;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.silviocelso.gestao_vagas.modules.candidate.CandidateRepository;
import br.com.silviocelso.gestao_vagas.modules.candidate.dto.ProfCandidateResponseDTO;

@Service
public class ProfCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    public ProfCandidateResponseDTO execute(UUID idCandidate) {
        var candidate = this.candidateRepository.findById(idCandidate)
                .orElseThrow(() -> {
                    throw new UsernameNotFoundException("User not found");
                });

        var candidateDTO = ProfCandidateResponseDTO.builder()
                .description(candidate.getDescription())
                .username(candidate.getUsername())
                .email(candidate.getEmail())
                .name(candidate.getName())
                .id(candidate.getId())
                .build();

        return candidateDTO;
    }
}
