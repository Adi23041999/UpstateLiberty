#include "PoliceZones.h"
#include "CFileMgr.h"
#include "CFileLoader.h"
#include "CZone.h"
#include "CZoneInfo.h"

static tPoliceRadioZone* ZoneSfx = nullptr;

void PoliceZones::Initialize()
{
    Events::initGameEvent.after += [] { InitializePoliceRadioZones(); };
}

void PoliceZones::InitializePoliceRadioZones()
{
    char* line;
    ZoneSfx = injector::ReadMemory<tPoliceRadioZone*>(0x57EB59);

    int fid = CFileMgr::OpenFile("data\\policeZoneSfx.dat", "r");
    if (fid > 0)
    {
        int index = 0;
        for (line = CFileLoader::LoadLine(fid); line; line = CFileLoader::LoadLine(fid))
        {
            if (*line == '\0' || *line == '#')
                continue;

            char zoneIdInFile[24];
            char zoneIdActual[8];
            unsigned int sampleIndex;

            // see CZone::CreateZone
            if (sscanf(line, "%s %d", zoneIdInFile, &sampleIndex) == 2)
            {
                strncpy_s(zoneIdActual, zoneIdInFile, 7);
                zoneIdActual[7] = '\0';

                ZoneSfx[index].m_nSampleIndex = sampleIndex;
                strcpy_s(ZoneSfx[index].m_aName, zoneIdActual);
                ZoneSfx[index].field_12 = 0; // unused

                ++index;
            }
        }
        CFileMgr::CloseFile(fid);
    }
}